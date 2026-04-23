const API = "http://localhost:8080/banks";

// ---------- HOME PAGE ----------
async function loadBanks() {
  const res = await fetch(API);
  const banks = await res.json();

  const table = document.getElementById("bankTable");
  table.innerHTML = "";

  banks.forEach(b => {
    table.innerHTML += `
      <tr>
        <td>${b.id}</td>
        <td>${b.name}</td>
        <td>${b.bankCode}</td>
        <td>${b.type}</td>
        <td>
          <button onclick="editBank(${b.id})">Edit</button>
          <button onclick="deleteBank(${b.id})">Delete</button>
        </td>
      </tr>`;
  });
}

function deleteBank(id) {
  const ok = confirm("⚠️ Are you sure you want to delete this bank?");

  if (!ok) return;

  fetch(`http://localhost:8080/banks/${id}`, {
    method: "DELETE"
  })
  .then(() => {
    alert("Bank deleted successfully!");
    loadBanks();   // refresh list
  });
}


function editBank(id) {
  window.location.href = `bank-form.html?id=${id}`;
}

function goToAdd() {
  window.location.href = "bank-form.html";
}

if (document.getElementById("bankTable")) {
  loadBanks();
}

// ---------- FORM PAGE ----------
const params = new URLSearchParams(window.location.search);
const bankId = params.get("id");

if (bankId) {
  document.getElementById("title").innerText = "Edit Bank";
  loadBank(bankId);
}

async function loadBank(id) {
  const res = await fetch(`${API}/${id}`);
  const data = await res.json();

  document.getElementById("id").value = data.data.id;
  document.getElementById("name").value = data.data.name;
  document.getElementById("bankCode").value = data.data.bankCode;
  document.getElementById("type").value = data.data.type;
}

async function saveBank() {
  const id = document.getElementById("id").value;

  const bank = {
    name: document.getElementById("name").value,
    bankCode: document.getElementById("bankCode").value,
    type: document.getElementById("type").value
  };

  if (id) {
    await fetch(`${API}/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(bank)
    });
    showMsg("Bank updated successfully");
  } else {
    await fetch(API, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(bank)
    });
    showMsg("Bank added successfully");
  }

  setTimeout(() => goHome(), 1000);
}

function showMsg(msg) {
  document.getElementById("msg").innerText = msg;
}

function goHome() {
  window.location.href = "home.html";
}