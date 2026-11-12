const fs=require("fs");

//write data into a file

fs.writeFile("demo.txt","Welcome to Node.js",(err)=>{
    if(err){
        console.log("write error: ",error);
        return;
    }
    console.log("file written successfully");
    
});

// 2. Read file contents
    fs.readFile("demo.txt", "utf8", (err, data) => {
        if (err) {
            console.log("Read error:", err);
            return;
        }

        console.log("File content:", data);
    });

    //3. Append data
        fs.appendFile("demo.txt", "\nLearning File Handling", (err) => {
            if (err) {
                console.log("Append error:", err);
                return;
            }

            console.log("Data appended successfully");
        });


        fs.copyFile("demo.txt", "copy.txt", (err) => {
                if (err) {
                    console.log("Copy error:", err);
                    return;
                }

                console.log("File copied successfully");

                // 5. Delete the copied file
                fs.unlink("copy.txt", (err) => {
                    if (err) {
                        console.log("Delete error:", err);
                        return;
                    }

                    console.log("Copied file deleted");
                });
            });