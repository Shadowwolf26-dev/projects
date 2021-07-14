using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System;

public class MovementController : MonoBehaviour
{
    #region Variables

    public float speed, counterSpeed, sprintMultiplier, jumpForce, slideForce, counterSpeedSlide;

    public float wallJumpMultiplier;

    public float mouseSensitivity;

    public Transform playerCam, orientation, feet;

    public KeyCode Sprint, Jump, Crouch;

    public LayerMask groundMask;

    private Vector3 crouchScale = new Vector3(1, 0.5f, 1), playerScale;
    private Vector3 SpawnPos;

    private bool Sprinting = false, Jumping = false, Crouching = false, hasCrouched = false;

    private bool isWallRight, isWallLeft, isWallRunning;

    public float wallrunForce, maxWallRunCameraTilt, wallRunCameraTilt;

    private Rigidbody rb; 

    private float x, z;
    private float desiredX, xRotation;

	#endregion

	#region Main Methods
	void Start()
    {
        SpawnPos = transform.position;
        Cursor.lockState = CursorLockMode.Locked;
        playerScale = transform.localScale;
        rb = transform.GetComponent<Rigidbody>();
    }

	private void FixedUpdate()
	{
     
        Move();
        WallRunInput();
    }

	void Update()
    {
        CheckWall();
        
        getInput();
        Look();
        if (transform.position.y <= -30) 
        {
            onDeath();
        }
    }
    #endregion

    private void WallRunInput() 
    {
        if (Input.GetKey(KeyCode.D) && isWallRight) StartWallrun();
        if (Input.GetKey(KeyCode.A) && isWallLeft) StartWallrun();
    }

    private void StartWallrun() 
    {
        rb.useGravity = false;
        isWallRunning = true;

        

        //Make sure char sticks to wall
        if (isWallRight)
            rb.AddForce(orientation.right * wallrunForce / 5 * Time.deltaTime);
        else
            rb.AddForce(-orientation.right * wallrunForce / 5 * Time.deltaTime);
    }

    private void StopWallRun() 
    {
        isWallRunning = false;
        rb.useGravity = true;
    }

    private void CheckWall() 
    {
        isWallRight = Physics.Raycast(transform.position, orientation.right, 1f, groundMask);
        isWallLeft = Physics.Raycast(transform.position, -orientation.right, 1f, groundMask);

        if (!isWallLeft && !isWallRight) StopWallRun();
    }

    private void onDeath() 
    {
        transform.position = SpawnPos;
        rb.velocity = new Vector3(0,0,0);
    }

    private void getInput() 
    {
        x = Input.GetAxis("Horizontal");
        z = Input.GetAxis("Vertical");

        if (Input.GetKey(Sprint)) Sprinting = true;
        else Sprinting = false;

        if (Input.GetKey(Jump)) Jumping = true;
        else Jumping = false;

        if (Input.GetKey(Crouch)) Crouching = true;
        else Crouching = false;
    }

    private void Look()
    {
        float mouseX = Input.GetAxis("Mouse X") * mouseSensitivity * Time.fixedDeltaTime;
        float mouseY = Input.GetAxis("Mouse Y") * mouseSensitivity * Time.fixedDeltaTime;

        Vector3 rot = playerCam.transform.localRotation.eulerAngles;
        desiredX = rot.y + mouseX;

        xRotation -= mouseY;
        xRotation = Mathf.Clamp(xRotation, -90f, 90f);

        playerCam.transform.localRotation = Quaternion.Euler(xRotation, desiredX, wallRunCameraTilt);
        orientation.transform.localRotation = Quaternion.Euler(0, desiredX, 0);

        if(Math.Abs(wallRunCameraTilt) < maxWallRunCameraTilt && isWallRunning && isWallRight)
            wallRunCameraTilt += Time.deltaTime * maxWallRunCameraTilt * 2;
        if (Math.Abs(wallRunCameraTilt) < maxWallRunCameraTilt && isWallRunning && isWallLeft)
            wallRunCameraTilt -= Time.deltaTime * maxWallRunCameraTilt * 2;

        if (wallRunCameraTilt > 0 && !isWallRight && !isWallLeft)
            wallRunCameraTilt -= Time.deltaTime * maxWallRunCameraTilt * 2;
        if (wallRunCameraTilt < 0 && !isWallRight && !isWallLeft)
            wallRunCameraTilt += Time.deltaTime * maxWallRunCameraTilt * 2;

    }


    private void Move()
	{
       

        //rb.AddForce(Vector3.down * Time.deltaTime * 10);

        float multiplier = 1f;
        float fwdMultiplier = 1f;


        if (!isGrounded() && !Jumping)
        {
            multiplier = 0.5f;
        }

        if (Sprinting) multiplier = sprintMultiplier;

        //if (!isGrounded()) multiplier = 0.5f;

        if (Crouching && isGrounded()) 
        {
            fwdMultiplier = 0f; 
            hasCrouched = true;
            transform.localScale = crouchScale;
            //transform.position = new Vector3(transform.position.x, transform.position.y - 0.5f, transform.position.z);
            if (rb.velocity.magnitude > 0.5f)
            {
                if (isGrounded())
                {
                    rb.AddForce(orientation.transform.forward * slideForce);
                }
            }
        }

        if (!Crouching && hasCrouched) 
        {
            transform.localScale = playerScale;
            transform.position = new Vector3(transform.position.x, transform.position.y + 0.5f, transform.position.z);
            hasCrouched = false;
        }

        if (Jumping && isWallRunning) 
        {
            
            if (isWallLeft && Input.GetKey(KeyCode.D) || isWallRight && Input.GetKey(KeyCode.A))
            {
                rb.AddForce(Vector2.up * jumpForce * 1.5f * wallJumpMultiplier);
                rb.AddForce(Vector3.up * jumpForce * 0.5f * wallJumpMultiplier);

                if (isWallRight || isWallLeft && Input.GetKey(KeyCode.A) || Input.GetKey(KeyCode.D)) rb.AddForce(-orientation.up * jumpForce * 1f);
                if (isWallRight && Input.GetKey(KeyCode.A)) rb.AddForce(-orientation.right * jumpForce * 3.2f);
                if (isWallLeft && Input.GetKey(KeyCode.D)) rb.AddForce(orientation.right * jumpForce * 3.2f);

                rb.AddForce(orientation.forward * jumpForce * 1f * wallJumpMultiplier);
            }
        }

        if (Jumping && isGrounded() && !isWallRunning) 
        {
            rb.AddForce(0f, orientation.transform.up.y * jumpForce, 0f);
            multiplier = 5f;
            Jumping = false;
        }

        rb.AddForce(z * speed * orientation.transform.forward * multiplier * fwdMultiplier);
        rb.AddForce(x * speed * orientation.transform.right * multiplier);

        Vector3 counter = new Vector3(counterSpeed * -rb.velocity.x, 0f, counterSpeed * -rb.velocity.z);

        if (isWallRunning) 
        {
            rb.AddForce(orientation.forward * wallrunForce * Time.deltaTime * speed);
        }

        rb.AddForce(counter);

        if (Crouching)
        {
            
            Vector3 counterSlide = new Vector3(counterSpeedSlide * -rb.velocity.x, 0f, counterSpeedSlide * -rb.velocity.z);
            rb.AddForce(counterSlide);
        }
    }

    private bool isGrounded() 
    {
        if (Physics.CheckSphere(feet.position, 0.4f, groundMask))
        {
            return true;
        }
        else return false;
       
    }
}
