using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class boosterTile : MonoBehaviour
{
    #region Variables

    public LayerMask playerMask;
    public float range, force;

    #endregion

    #region Main Methods
    void Start()
    {
        
    }

    
    void FixedUpdate()
    {
        if (Physics.CheckSphere(transform.position, range, playerMask)) 
        {
            Collider[] col = Physics.OverlapSphere(transform.position,range,playerMask);

            foreach (Collider c in col) 
            {
                Rigidbody rb = c.transform.GetComponent<Rigidbody>();

                if (rb != null) 
                {
                    rb.AddExplosionForce(force, c.transform.position, range, 100f);
                }
            }

        }
    }
    #endregion
}
