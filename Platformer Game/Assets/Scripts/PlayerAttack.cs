using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerAttack : MonoBehaviour
{
    #region Variables
    public GameObject particle1;
    public Transform particleSpawn;

    private bool attacked = false;
    #endregion

    #region Main Methods
    void Start()
    {
        
    }

    
    void Update()
    {
        if (Input.GetMouseButton(0) && !attacked) StartCoroutine(attack1());
    }
    #endregion

    IEnumerator attack1() 
    {
        attacked = true;
        particle1.SetActive(true);
        yield return new WaitForSeconds(5f);
        particle1.SetActive(false);
        attacked = false;
    }
}
