function login() {
  const email = document.getElementById("email").value;
  const senha = document.getElementById("senha").value;

  if (email === "admin@admin.com" && senha === "123") {
    localStorage.setItem("perfil", "ADMIN");
    window.location.href = "index.html";
  } 
  else if (email === "user@user.com" && senha === "123") {
    localStorage.setItem("perfil", "USER");
    window.location.href = "index.html";
  } 
  else {
    alert("Login inválido");
  }
}

function verificarLogin() {
  if (!localStorage.getItem("perfil")) {
    window.location.href = "login.html";
  }
}

function isAdmin() {
  return localStorage.getItem("perfil") === "ADMIN";
}

function logout() {
  localStorage.clear();
  window.location.href = "login.html";
}
