 
#!/bin/bash

while true
do
while read in
do
ping -c 2 $in
if [ $?==0 ]
then
        java new_client $in
fi
done < nodes.txt
done
