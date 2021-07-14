using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Movement : MonoBehaviour
{
    #region Variables

    public float speed;
    
    [Range(1, 500)]
    public float mouseSensitivity;


    private CharacterController controller;
    private float xRotation = 0f;
    private float yRotation = 0f;
    #endregion

    #region Main Methods
    void Start()
    {
        Cursor.lockState = CursorLockMode.Locked;

        controller = transform.GetComponent<CharacterController>();
    }

    
    void Update()
    {

        float mouseX = Input.GetAxis("Mouse X") * mouseSensitivity * Time.deltaTime;
        float mouseY = Input.GetAxis("Mouse Y") * mouseSensitivity * Time.deltaTime;

        float x = Input.GetAxis("Horizontal") * speed * Time.deltaTime;
        float z = Input.GetAxis("Vertical") * speed * Time.deltaTime;

        Vector3 move = transform.forward * z + transform.right * x;
        xRotation -= mouseY;
        xRotation = Mathf.Clamp(xRotation, -90f, 90f);
        yRotation -= mouseX;


        transform.localRotation = Quaternion.Euler(xRotation, -yRotation, 0f);
        controller.Move(move);
    }
    #endregion
}
