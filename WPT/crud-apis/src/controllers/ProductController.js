export async function saveProduct(request, response) => {
    try {
        // step 1: get data from client {name:"", price: 6677, description:"", qty:8} 
        const { name, price, description, qty } = request.body;

        // step 2: create a SQL INSERT query
        // const insertQry = `INSERT into product(name, price, description, qty) VALUES('${name}', ${price}, '${description}', ${qty})`
        // this above approach (concating data directly in the SQL query) is prone to sql injection attack 

        const insertQry = `INSERT into product(name, price, description, qty) VALUES(?,?,?,?)`;

        // step 3: run this query in the db
        const [result] = await sqlConnectionPool.query(insertQry, [name, price, description, qty]);
        console.log(result.insertId);

        response.send({ message: "product inserted", insertedId: result.insertId });

    } catch (error) {
        console.log(error);
        response.status(500).send({ message: "Something went wrong" });
    }
}