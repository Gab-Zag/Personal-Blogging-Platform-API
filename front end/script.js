const API = "http://localhost:9090/articles";

// 🔹 GET ALL
function loadArticles() {
    fetch(API)
        .then(res => res.json())
        .then(data => {
            const container = document.getElementById("articles");
            container.innerHTML = "";

            data.forEach(a => {
                const div = document.createElement("div");
                div.className = "article";
                div.innerHTML = `
                    <h3>${a.title}</h3>
                    <p>${a.description}</p>
                    <small>ID: ${a.id}</small><br>
                    <button onclick="deleteArticle(${a.id})">Delete</button>
                `;
                container.appendChild(div);
            });
        });
}

// 🔹 GET BY ID
function getById() {
    const id = document.getElementById("searchId").value;

    fetch(`${API}/${id}`)
        .then(res => res.json())
        .then(data => {
            document.getElementById("single").textContent =
                JSON.stringify(data, null, 2);
        });
}

// 🔹 CREATE
function createArticle() {
    const title = document.getElementById("title").value;
    const description = document.getElementById("description").value;

    if (!title || !description) {
        alert("Title and Description are required");
        return;
    }

    const article = { title, description };

    fetch(`${API}/create`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(article)
    })
    .then(res => {
        if (!res.ok) throw new Error("Failed to create");
        return res.text();
    })
    .then(() => {
        loadArticles();
    })
    .catch(err => alert(err.message));
}

// 🔹 UPDATE
function updateArticle() {
    const id = document.getElementById("updateId").value;
    const title = document.getElementById("updateTitle").value;
    const description = document.getElementById("updateDescription").value;

    const article = { title, description };

    fetch(`${API}/update/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(article)
    })
    .then(() => loadArticles());
}

// 🔹 DELETE
function deleteArticle(id) {
    fetch(`${API}/${id}`, { method: "DELETE" })
        .then(() => loadArticles());
}

// 🔹 AUTO LOAD
window.onload = loadArticles;