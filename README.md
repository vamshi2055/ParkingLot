# Problem Statement

I own a parking lot that can hold up to 'n' cars at any given point in time. Each slot is
given a number starting at 1 increasing with increasing distance from the entry point
in steps of one. I want to create an automated ticketing system that allows my
customers to use my parking lot without human intervention.
When a car enters my parking lot, I want to have a ticket issued to the driver. The
ticket issuing process includes us documenting the registration number (number
plate) and the colour of the car and allocating an available parking slot to the car
before actually handing over a ticket to the driver (we assume that our customers are
nice enough to always park in the slots allocated to them). The customer should be
allocated a parking slot which is nearest to the entry. At the exit the customer returns
the ticket which then marks the slot they were using as being available.

Due to government regulation, the system should provide me with the ability to find
out:

1)Registration numbers of all cars of a particular colour.
2) Slot number in which a car with a given registration number is parked.
3) Slot numbers of all slots where a car of a particular colour is parked.

We interact with the system via a simple set of commands which produce a specific
output. Please take a look at the example below, which includes all the commands
you need to support - they're self explanatory. The system should allow input in two
ways. Just to clarify, the same codebase should support both modes of input - we
don't want two distinct submissions.

1) It should provide us with an interactive command prompt based shell where
commands can be typed in
2) It should accept a filename as a parameter at the command prompt and read the
commands from that file


How to build and run the program:

# Before you run

1. Get the latest version of JDK.
2. Get the latest version of maven.


#Build Commands

Run the following command

mvn clean install

# Execution Commands

java -jar target\parkinglot-0.0.1-SNAPSHOT.jar

#Execute with a file input

java -jar target\parkinglot-0.0.1-SNAPSHOT.jar input.txt


# Input:

create_parking_lot 6<br />
park KA-01-HH-1234 White<br />
park KA-01-HH-9999 White<br />
park KA-01-BB-0001 Black<br />
park KA-01-HH-7777 Red<br />
park KA-01-HH-2701 Blue<br />
park KA-01-HH-3141 Black<br />
leave 4<br />
status<br />
park KA-01-P-333 White<br />
park DL-12-AA-9999 White<br />
registration_numbers_for_cars_with_colour White<br />
slot_numbers_for_cars_with_colour White<br />
slot_number_for_registration_number KA-01-HH-3141<br />
slot_number_for_registration_number MH-04-AY-1111<br />

# Output:

Created a parking lot with 6 slots<br />
Allocated slot number: 1<br />
Allocated slot number: 2<br />
Allocated slot number: 3<br />
Allocated slot number: 4<br />
Allocated slot number: 5<br />
Allocated slot number: 6<br />
Slot number 4 is free<br />
Slot No.     Registration No   Colour<br />
1            KA-01-HH-1234     White<br />
2            KA-01-HH-9999     White<br />
3            KA-01-BB-0001     Black<br />
5            KA-01-HH-2701     Blue<br />
6            KA-01-HH-3141     Black<br />
Allocated slot number: 4<br />
Sorry the Go Jek parking lot is full.<br />
A-01-HH-1234,KA-01-HH-9999,KA-01-P-333<br />
1,2,4<br />
Allocated slot number:6<br />
Not found<br />

