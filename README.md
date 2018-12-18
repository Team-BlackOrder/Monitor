# Monitor

“Monitor” is a cloud-based sensor monitoring and alert management platform which can be used
to centrally monitor any device regardless of its location. The system can be used to alert on
certain events based on the readings coming from the sensors.

The system collects sensor data readings from different sensors such as
Temperature sensors, Humidity sensors, Pressure sensors etc.

Monitor system performs monitoring part only (The alert generation and notifying the user when
there is a device failure). There are third party sensor data providers such as Aretas and Helium
which sends the sensor readings to our system.

The alert generation logic is simple for temperature sensors. If the current sensor reading goes
above a certain threshold the system should trigger an alert. But the alert generation logic can
be more complex for other sensors such as Pressure sensors and Vibration sensors. The initial
version of the system only supports temperature sensors.

When there is an alert, the system notify the user via Email, SMS or phone calls. The
user select the notification channels that they want.

The system visualize the sensor readings for each sensor and the status of the sensor to
the user using a web portal. The sensor readings visualized as graphs for each
sensor and user can see the historical alerts occurred in each sensor via the user
interface.


### Has Used:

* Used Apache NiFi for data ingestion.(Architecture diagram is available in Nifi template directory)

* Used MongoDB to store the data.

* Used Java Lagom framework to implement the Microservices.
