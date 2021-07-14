using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MouseLook : MonoBehaviour
{
    #region Variables

    [Range(1, 500)]
    public float mouseSensitivity;
    private float xRotation = 0f;
    private float yRotation = 0f;

    #endregion

    #region Main Methods
    void Start()
    {
        
    }

    
    void Update()
    {
        float mouseX = Input.GetAxis("Mouse X") * mouseSensitivity * Time.deltaTime;
        float mouseY = Input.GetAxis("Mouse Y") * mouseSensitivity * Time.deltaTime;

        xRotation -= mouseY;
        xRotation = Mathf.Clamp(xRotation, -90f, 90f);
        yRotation -= mouseX;

        transform.localRotation = Quaternion.Euler(xRotation, -yRotation, 0f);
    }
    #endregion
}
