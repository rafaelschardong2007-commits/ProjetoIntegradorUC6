/* ================= CONFIG ================= */
const API_URL = 'http://localhost:8080/api';
let usuarioLogado = null;

/* ================= UTIL ================= */
const $ = (s) => document.querySelector(s);
const $$ = (s) => document.querySelectorAll(s);

/* ================= LOGIN ================= */
async function handleLogin(e) {
  e.preventDefault();

  const username = $('#username').value;
  const password = $('#password').value;

  const res = await fetch(`${API_URL}/login`, {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify({ username, password })
  });

  if (!res.ok) {
    alert('Usuário ou senha inválidos');
    return;
  }

  usuarioLogado = await res.json();
  localStorage.setItem('usuario', JSON.stringify(usuarioLogado));

  window.location.href = 'index.html';
}

/* ================= SESSÃO ================= */
function carregarUsuario() {
  const u = localStorage.getItem('usuario');
  if (u) usuarioLogado = JSON.parse(u);
}

/* ================= ALUNOS ================= */
async function listarAlunos() {
  const res = await fetch(`${API_URL}/alunos`);
  const alunos = await res.json();

  const tbody = $('#tabela-alunos');
  if (!tbody) return;

  tbody.innerHTML = '';
  alunos.forEach(a => {
    tbody.innerHTML += `
      <tr>
        <td>${a.id}</td>
        <td>${a.nome}</td>
        <td>${a.email}</td>
        <td>${a.nivel}</td>
        ${usuarioLogado.role === 'ADMIN' ? 
          `<td><button class="btn btn-danger btn-sm" onclick="excluirAluno(${a.id})">Excluir</button></td>` 
          : ''
        }
      </tr>
    `;
  });
}

async function cadastrarAluno(e) {
  e.preventDefault();

  const aluno = {
    nome: $('#nome').value,
    email: $('#email').value,
    nivel: $('#nivel').value
  };

  await fetch(`${API_URL}/alunos`, {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify(aluno)
  });

  alert('Aluno cadastrado!');
  listarAlunos();
}

async function excluirAluno(id) {
  await fetch(`${API_URL}/alunos/${id}`, { method: 'DELETE' });
  listarAlunos();
}

/* ================= PROGRESSO ================= */
async function salvarProgresso(alunoId, licaoId) {
  await fetch(`${API_URL}/progresso`, {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify({
      alunoId,
      licaoId,
      concluido: true
    })
  });
}

async function carregarProgresso(alunoId) {
  const res = await fetch(`${API_URL}/progresso/${alunoId}`);
  return await res.json();
}

/* ================= LIÇÕES ================= */
function iniciarLicao(id) {
  alert(`Lição ${id} iniciada`);
  salvarProgresso(usuarioLogado.id, id);
}

/* ================= CONTROLE DE MENU ================= */
function controlarMenu() {
  if (!usuarioLogado) return;

  if (usuarioLogado.role !== 'ADMIN') {
    $$('.admin-only').forEach(e => e.style.display = 'none');
  }
}

/* ================= LOGOUT ================= */
function logout() {
  localStorage.removeItem('usuario');
  window.location.href = 'login.html';
}

/* ================= INIT ================= */
document.addEventListener('DOMContentLoaded', () => {
  carregarUsuario();
  controlarMenu();

  if ($('#login-form')) $('#login-form').addEventListener('submit', handleLogin);
  if ($('#form-aluno')) $('#form-aluno').addEventListener('submit', cadastrarAluno);
  if ($('#tabela-alunos')) listarAlunos();
});
