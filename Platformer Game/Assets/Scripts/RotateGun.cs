 using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RotateGun : MonoBehaviour
{
    #region Variables
    public Grapple grappling;

    private Quaternion desiredRotation;
    private float rotationSpeed = 5f; 
    #endregion

    #region Main Methods
    void Start()
    {
        
    }

    
    void LateUpdate()
    {

        if (!grappling.IsGrappling()) desiredRotation = transform.parent.rotation;
        else 
        {
            desiredRotation = Quaternion.LookRotation(grappling.GetGrapplePoint() - transform.position);
        }

        transform.rotation = Quaternion.Lerp(transform.rotation, desiredRotation, Time.deltaTime * rotationSpeed);

    }
    #endregion
}
