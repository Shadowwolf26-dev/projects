using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Grapple : MonoBehaviour
{
    #region Variables
    private LineRenderer lr;
    private Vector3 grapplePoint;
    public LayerMask canGrappleOn;
    public GameObject player;
    public Transform gunTip, cam;
    public float maxDistance;
    private SpringJoint joint;
    #endregion

    #region Main Methods
    void Start()
    {
        lr = transform.GetComponent<LineRenderer>();
    }

    
    void Update()
    {


        if (Input.GetMouseButtonDown(0))
            StartGrapple();
        else if (Input.GetMouseButtonUp(0))
            StopGrapple();
    }

	private void LateUpdate()
	{
        DrawRope();
    }
	#endregion

	void StartGrapple() 
    {
        Time.timeScale = 0.75f;
        //Time.fixedDeltaTime = 0.25f;
        

        lr.positionCount = 2;
        RaycastHit hit;
        if (Physics.Raycast(cam.position, cam.forward, out hit, maxDistance, canGrappleOn)) 
        {
            grapplePoint = hit.point;
            joint = player.AddComponent<SpringJoint>();

            joint.autoConfigureConnectedAnchor = false;
            joint.connectedAnchor = grapplePoint;

            float distanceFromPoint = Vector3.Distance(player.transform.position, grapplePoint);

            joint.maxDistance = distanceFromPoint * 0.8f;
            joint.minDistance = distanceFromPoint * 0.25f;

            joint.spring = 4.5f;
            joint.damper = 5f;
            joint.massScale = 4.5f;
        }

    }

    void DrawRope() 
    {
        if (!joint) return;
        lr.SetPosition(0, gunTip.position);
        lr.SetPosition(1, grapplePoint);
    }

    void StopGrapple() 
    {
        lr.positionCount = 0;
        Destroy(joint);
        Time.timeScale = 1f;

    }

    public bool IsGrappling() 
    {
        return joint != null;
    }

    public Vector3 GetGrapplePoint() 
    {
        return grapplePoint;
    }

}
