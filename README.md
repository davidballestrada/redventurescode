# redventurescode
Red Ventures Code

Please consider the following:

- The authentication for the endpoint is user: admin, password: adminpass
- Add a header to identify the client device, the key is: IOTDeviceID
- The file to save the access log (like persist) is EmployeeAccessLog.txt, in iotdevices folder
- The existing data is in some variables, there are devices Id: 1, 2, 3; employees Id: 1, 2, 3, 4, 5; access allowed: Employee 1 -> Doors: 1; Employee 2 -> 1, 3; Employee 3 -> 1, 2; Employee 4 -> 3; Employee 5 -> 1, 2, 3
- The configured port is: 8085
- The context is: /redventures/iot
- The end point is: http://localhost:8085/redventures/iot/iotDevice/validateIOT/
