#!/bin/bash

echo "Testing with 200,000,000 (200 millions) iterations"

time curl http://localhost:7003/GraalVMJAXRSDemo/rest/graal/benchmark/200000000
