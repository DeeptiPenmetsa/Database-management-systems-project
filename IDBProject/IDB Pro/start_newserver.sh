#!/bin/bash

var_str=( planetlab2.unl.edu planetlab1.unr.edu planetlab2.cs.uml.edu planetlab-03.cs.princeton.edu planetlab1.rutgers.edu planetlab3.ucsd.edu pl3.cs.unm.edu planetlab2.cs.pitt.edu planetlab2.cs.uoregon.edu planetlab2.tsuniv.edu planetlab2.cs.ucla.edu planetlab1.cs.du.edu planetlab2.citadel.edu planetlab2.rutgers.edu node1.planetlab.mathcs.emory.edu ricepl-5.cs.rice.edu planetlab2.cs.purdue.edu planetlab2.utdallas.edu planetlab1.ucsd.edu pl1.eecs.utk.edu planetlab1.cs.unc.edu planetlab2.unr.edu planetlab3.eecs.umich.edu planetlab1.emich.edu planetlab1.csuohio.edu planetlab2.acis.ufl.edu planetlab1.unl.edu planetlab2.clemson.edu planetlab3.cnds.jhu.edu planetlab2.temple.edu planetlab-02.bu.edu planetlab5.eecs.umich.edu planetlab4.tamu.edu flow.colgate.edu planetlab2.uta.edu plab3.eece.ksu.edu planetlabone.ccs.neu.edu planetlabtwo.ccs.neu.edu planetlab1.cs.purdue.edu planetlab3.wail.wisc.edu salt.planetlab.cs.umd.edu )
for i in "${var_str[@]}"
do
path="umkc_vcqm2@$i"	
ssh -n -f $path "sh -c 'sh server_chain.sh > /dev/null 2>&1 &'"
done
