# Meeting Scheduler

Design a meeting scheduler to book a meeting and return the name of the room booked.

## Goals of the System

- Book a room for the meeting and return the name of the room booked
- Maintain a history of the meetings booked

## API

Write an API which accepts a start time and an end time, and returns the meeting room name for the booked scheduled time.

## Functionality

- When a user wants to schedule a meeting, they provide the desired start and end times to the system.
- The system attempts to book a room for the specified time slot.
- If the requested room is already booked by someone else, one of the following actions can be taken:
  - The system chooses another available room for the meeting, or
  - The user can change their preferred meeting timings.
- If all the rooms are fully booked for the given time slot, the meeting cannot be scheduled during that time.

## Classes Involved

1. **Room**:
   - Contains a name (hopefully unique) for the room.
   - Has a function `book()` to book the room.
   - Each room has a calendar, which is a vector of meetings.

2. **Meeting**:
   - Contains a start time and an end time for the meeting.
   - Each meeting is tied to a specific room (a meeting cannot span across multiple rooms).

3. **Scheduler**:
   - Represents the system that the user interacts with.
   - Keeps track of the available rooms.
   - Has a function `book()` to book a meeting.

Note: The class diagram may be modified as the implementation progresses. Additional member variables and functions may be introduced to achieve the desired objectives.
