OOSD_project_part2
==================

Part 2 of the Object Oriented Software Design search engine project

Tim - Checkpoint & Allocation
Joe - KeyStorage & ValueStorage
Dylan - LinearFileDatabase
Jason - DiskSpace, set up Unit Tests

3 files - one for two bit arrays (Allocate & Checkpoint), one for key/value, one for identifiers
We have decided to remove the Node class (for now) for our LinearFileDatabase.java class. We discussed and discovered a (potentially) better way to implement it.

DiskSpace will take in an extra parameter, fileName because we will be using 2 separate files for Keys and Identifiers 
