import express from "express";
import { createPool } from "mysql2/promise";
import{welcome} from "./src/controllers/WelcomeController.js";
const app = express();
app.use(express.json());



app.get("/",welcome);

app.post("/product", );

app.get("/product", async (request, response) => {
    try {

        // step 1: create a select query

        const fetchAllProductsQry = "SELECT * FROM product";

        // step 2: run this query
        const [result] = await sqlConnectionPool.query(fetchAllProductsQry);

        response.send(result);


    } catch (error) {
        console.log(error);
        response.status(500).send({ message: "Something went wrong" });
    }
});

app.get("/product/:id", async (request, response) => {
    try {

        // step 1: read id from url parameter

        const { id } = request.params;

        // step 2: create a select query

        const fetchByIdQuery = "SELECT * FROM product WHERE id = ?";

        // step 3: run this query

        const [result] = await sqlConnectionPool.query(fetchByIdQuery, [id] );

        if(result.length > 0){
            response.send(result[0]);
        }
        else{
            response.status(404).send({message:`Product with id ${id} not found`});
        }

    } catch (error) {
        console.log(error);
        response.status(500).send({ message: "Something went wrong" });
    }
});

app.delete("/product/:id", async (request, response)=>{
    try {

        // step 1: read id from url parameter

        const { id } = request.params;

        // step 2: create a delete query

        const deleteQry = "DELETE FROM product WHERE id = ?";

        // step 3: run this query

        const [result] = await sqlConnectionPool.query(deleteQry, [id]);
        console.log(result);

        response.send({message:"Product Deleted"});


    } catch (error) {
        console.log(error);
        response.status(500).send({ message: "Something went wrong" });
    }
});


app.listen(7500);