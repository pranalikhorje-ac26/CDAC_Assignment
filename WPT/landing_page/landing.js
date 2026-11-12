// 1. Menu: array containing objects

const menu = [
    { id: 1, name: "Konkan Cold Coffee", price: 120 },
    { id: 2, name: "Coastal Special Combo", price: 199 },
    { id: 3, name: "Chocolate Brownie", price: 100 },
    { id: 4, name: "Sandwich", price: 80 },
    { id: 5, name: "Tea", price: 40 }
];

// Empty cart array
let cart = [];


// 2. Display menu items in the dropdown

const itemSelect = document.getElementById("item");

menu.forEach(function (item) {

    const option = document.createElement("option");

    option.setAttribute("value", item.id);

    option.textContent = item.name + " - ₹" + item.price;

    itemSelect.appendChild(option);

});


// 3. Add item to cart

function addItem() {

    const id = Number(itemSelect.value);

    const quantity = parseInt(
        document.getElementById("quantity").value
    );

    const error = document.getElementById("error");

    // Validate item selection
    if (id === 0 || !id) {
        error.textContent = "Please select an item.";
        return;
    }

    // Validate quantity
    if (!Number.isInteger(quantity) || quantity <= 0) {
        error.textContent = "Enter a valid positive quantity.";
        return;
    }

    // Find selected product
    const product = menu.find(function (item) {
        return item.id === id;
    });

    // Add product object to cart
    cart.push({
        id: product.id,
        name: product.name,
        price: product.price,
        quantity: quantity
    });

    error.textContent = "";

    displayCart();

    calculateBill();

}


// 4. Display cart using DOM methods

function displayCart() {

    const cartList = document.getElementById("cart");

    cartList.innerHTML = "";

    cart.forEach(function (item, index) {

        const li = document.createElement("li");

        li.textContent =
            item.name + " x " + item.quantity +
            " = ₹" + (item.price * item.quantity) + " ";

        // Create Remove button
        const button = document.createElement("button");

        button.textContent = "Remove";

        button.onclick = function () {

            // Remove item from array
            cart.splice(index, 1);

            displayCart();

            calculateBill();

        };

        li.appendChild(button);

        cartList.appendChild(li);

    });

}


// 5. Callback function example

function applyRule(amount, rule) {

    return rule(amount);

}


// 6. Calculate bill

function calculateBill() {

    // Calculate subtotal using reduce()
    const subtotal = cart.reduce(function (total, item) {

        return total + (item.price * item.quantity);

    }, 0);


    // Discount using if-else ladder
    let discount = 0;

    if (subtotal >= 1000) {

        discount = subtotal * 0.15;

    } else if (subtotal >= 500) {

        discount = subtotal * 0.10;

    } else if (subtotal >= 200) {

        discount = subtotal * 0.05;

    }


    // Delivery charge using switch
    let delivery = 0;

    const area = document.getElementById("area").value;

    switch (area) {

        case "pickup":
            delivery = 0;
            break;

        case "nearby":
            delivery = 30;
            break;

        case "city":
            delivery = 50;
            break;

        default:
            delivery = 0;

    }


    // Call callback with an anonymous function
    const extra1 = applyRule(subtotal, function (amount) {

        return amount * 0;

    });


    // Call callback with an arrow function
    const extra2 = applyRule(subtotal, amount => amount * 0);


    // Calculate total
    const total = subtotal - discount + delivery + extra1 + extra2;


    // Count total quantity
    const count = cart.reduce(function (sum, item) {

        return sum + item.quantity;

    }, 0);


    // Conditional operator
    const itemText = count === 1 ? "item" : "items";


    // Display bill using template literal
    document.getElementById("bill").textContent =
        `Items: ${count} ${itemText} | ` +
        `Subtotal: ₹${subtotal} | ` +
        `Discount: ₹${discount} | ` +
        `Delivery: ₹${delivery} | ` +
        `Final Total: ₹${total}`;

}


// 7. Promise for placing an order

function orderPromise() {

    return new Promise(function (resolve, reject) {

        // Reject if the cart is empty
        if (cart.length === 0) {

            reject("Your cart is empty. Please add an item.");

        } else {

            // Wait for 2 seconds
            setTimeout(function () {

                const orderNumber = Math.floor(
                    1000 + Math.random() * 9000
                );

                resolve("Order placed successfully! Order Number: " +
                    orderNumber);

            }, 2000);

        }

    });

}


// 8. Async/await and try/catch

async function placeOrder() {

    const message = document.getElementById("message");

    // Display message while waiting
    message.textContent = "Placing your order...";

    try {

        const result = await orderPromise();

        message.textContent = result;

    } catch (error) {

        message.textContent = error;

    }

}


// 9. Display special offer after 3 seconds

setTimeout(function () {

    document.getElementById("offer").textContent =
        "Special Offer: Enjoy 10% off on selected cafe favourites!";

}, 3000);