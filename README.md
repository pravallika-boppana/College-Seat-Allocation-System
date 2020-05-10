# College-Seat-Allocation-System
Mini Project details :

Design and develop a “College seat allocation system”. We will focus on the below use-cases only. No UI and No DB.  The system is expected to be used for 3 counselling sessions where students share their college preferences.

Use cases :

    1. Input : System takes input as a stream of data and a large files. The team can decide on the details of the data. On the high level, the data should talk about the below
        a. Stream consists of “Students preference to colleges” information. You can assume that this stream of data keeps flowing into your system for few days(Counselling period).
        b. Assume you have a large file with Student details with ranks
        c. Assume you have a large file with College details including the seats per branch.
    2. Process : System should allocate seats to students based on their preference and rank. System should also maintain in-memory DS to handle the APIs consistently.
    3. Output : System should provide the APIs that can give the below details
        a. Given a student ID, provide the seat allocation
        b. Return the topX desirable colleges
        c. Return the topX filled
        d. Return the topX unfilled colleges
