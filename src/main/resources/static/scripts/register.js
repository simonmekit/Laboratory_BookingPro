// Function to render product listings
function renderProducts(hospitals) {
    const hospitalList = document.getElementById('affiliation');
    hospitalList.innerHTML = '';
    hospitals.forEach(hospital => {
        const productElement = document.createElement('div');
        productElement.innerHTML = `
            <p>${product.name} - $${product.price}</p>
            <button onclick="addToCart(${product.id})">Add to Cart</button>
        `;

        productList.appendChild(productElement);
    });
}

// Function to fetch and parse JSON data
async function fetchProductData() {
    fetch("../static/data/hospitals.json")
        .then((res) => {
            if (!res.ok) {
                throw new Error(`HTTP  error! Status: ${res.status}`);
            }
            return res.json();
        })
        .then((data) => renderProducts(data))
        .catch((error) =>
            console.error("Unable to fetch data: ", error));
}
fetchProductData();