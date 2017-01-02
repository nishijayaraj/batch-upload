Java program to load large data set  into DB as batches.
This would reduce I/O perations to considerable extent and hence speed up the operations.

In this example DB type : MySQL
                DB Name :test
                Table  :batch
                
This progrm would read data from the cav file named input.csv and write the first three fields into the table "batch" .
Writes the records into DB as batches of 1000. 

When we tried to write this file with 18 lakhs records,it took us more than 30 minutes. But it was reduced to 30-40 seconds when we upload them as the batches of 1000 records
        
                
      
