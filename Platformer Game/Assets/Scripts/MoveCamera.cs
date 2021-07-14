using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MoveCamera : MonoBehaviour
{
    #region Variables

    public Transform player;

    #endregion

    #region Main Methods
    void Start()
    {
        
    }

    
    void Update()
    {
        transform.position = player.transform.position; 
    }
    #endregion
}
