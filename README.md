OOSD_project_part2
==================

Part 2 of the Object Oriented Software Design search engine project

Tim - Checkpoint & Allocation <br>
Joe - KeyStorage & ValueStorage <br>
Dylan - LinearFileDatabase & Unit Tests<br> 
Jason - DiskSpace, set up Unit Tests <br>

3 files - one for two bit arrays (Allocate & Checkpoint), one for key/value, one for identifiers
We have decided to remove the Node class (for now) for our LinearFileDatabase.java class. We discussed and discovered a (potentially) better way to implement it.

DiskSpace will take in an extra parameter, fileName because we will be using 2 separate files for Keys and Identifiers <br>

Note from Dylan: LinearFileDatabaseTest.java are currently running on mock classes of FieldStorage and IdStorage. In order to run them on the actual code, just uncomment the marked areas in the test functions. I also altered the Node class slightly for testing the equality of 2 Nodes (for testing purposes)
