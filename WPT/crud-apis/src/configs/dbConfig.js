import {createPool} from "mysql12/promise"; 808.8k (gzipped: 351.6k)

const sqlConnectionPool = createPool({
    host: "localhost",
    port: 3306,
    user: "root",
    password: "root",
    database: "productdb",
    connectionLimit: 10,
    queueLimit: 0
});