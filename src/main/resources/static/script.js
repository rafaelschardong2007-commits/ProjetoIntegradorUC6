
let lessons = {
  1: {
    id: 1,
    title: 'Lição 1: Introdução ao Inglês',
    description: 'Saudações, alfabeto, e frases básicas.',
    image: 'https://images.unsplash.com/photo-1529070538774-1843cb3265df',
    quiz: {
      question: 'Como se diz "Olá" em inglês?',
      options: ['Hi', 'Hola', 'Oi', 'Ciao'],
      answerIndex: 0
    }
  },
  2: {
    id: 2,
    title: 'Lição 2: Vocabulário Essencial',
    description: 'Números, cores, família e comidas.',
    image: 'https://images.unsplash.com/photo-1559526324-593bc073d938',
    quiz: {
      question: 'Qual dessas palavras é uma cor?',
      options: ['Dog', 'Blue', 'Run', 'Book'],
      answerIndex: 1
    }
  }
};

const $ = (s) => document.querySelector(s);
const $$ = (s) => Array.from(document.querySelectorAll(s));

function saveState(k, v) {
  localStorage.setItem(k, JSON.stringify(v));
}
function loadState(k, f = null) {
  const v = localStorage.getItem(k);
  return v ? JSON.parse(v) : f;
}

const THEME_KEY = 'curso_theme';
function applyTheme(theme) {
  document.documentElement.setAttribute('data-theme', theme);
  saveState(THEME_KEY, theme);
}
function toggleTheme() {
  applyTheme(loadState(THEME_KEY, 'dark') === 'dark' ? 'light' : 'dark');
}

const LOGIN_KEY = 'login';

function handleLogin(e) {
  e.preventDefault();
  const f = e.target;

  const username = f.username.value.trim();
  const password = f.password.value.trim();

  fetch('http://localhost:8080/api/login', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify({ username, password })
  })
  .then(res => {
    if (!res.ok) throw new Error();
    return res.json();
  })
  .then(user => {
    saveState(LOGIN_KEY, user);
    window.location.href = 'lessons.html';
  })
  .catch(() => alert('Usuário ou senha inválidos'));
}


const PROGRESS_KEY = 'progress';

function getProgress() {
  return loadState(PROGRESS_KEY, {});
}

function setLessonCompleted(lessonId) {
  const p = getProgress();
  p[lessonId] = true;
  saveState(PROGRESS_KEY, p);


  fetch('http://localhost:8080/api/progresso', {
    method: 'POST',
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify({
      lessonId,
      completed: true
    })
  });

  updateProgressUI();
}

function updateProgressUI() {
  const p = getProgress();
  const total = Object.keys(lessons).length;
  const done = Object.values(p).filter(Boolean).length;
  const percent = Math.round((done / total) * 100);

  const bar = $('#progress-bar');
  if (bar) {
    bar.style.width = percent + '%';
    bar.textContent = percent + '%';
  }
}
function startLesson(id) {
  const l = lessons[id];
  if (!l) return;

  $('#lesson-title').textContent = l.title;
  $('#lesson-description').textContent = l.description;
  $('#lesson-image').src = l.image;

  const quiz = $('#lesson-quiz');
  quiz.innerHTML = `<p>${l.quiz.question}</p>`;

  l.quiz.options.forEach((opt, i) => {
    quiz.innerHTML += `
      <div>
        <input type="radio" name="quiz" value="${i}"> ${opt}
      </div>
    `;
  });

  quiz.innerHTML += `<button class="btn btn-primary mt-2" id="sendQuiz">Responder</button>`;

  $('#sendQuiz').onclick = () => {
    const sel = document.querySelector('input[name=quiz]:checked');
    if (!sel) return alert('Escolha uma opção');

    if (parseInt(sel.value) === l.quiz.answerIndex) {
      alert('Correto!');
      setLessonCompleted(id);
    } else {
      alert('Incorreto');
    }
  };

  $('#lesson-content').style.display = 'block';
}

function renderLessonCards() {
  const c = $('#lessons-container');
  if (!c) return;

  c.innerHTML = '';
  Object.values(lessons).forEach(l => {
    c.innerHTML += `
      <div class="col-md-4">
        <div class="card p-3">
          <img src="${l.image}" class="img-fluid mb-2">
          <h5>${l.title}</h5>
          <p>${l.description}</p>
          <button class="btn btn-success" onclick="cursoIngles.startLesson(${l.id})">
            Abrir
          </button>
        </div>
      </div>
    `;
  });
}

document.addEventListener('DOMContentLoaded', () => {
  applyTheme(loadState(THEME_KEY, 'dark'));

  const loginForm = $('#login-form');
  if (loginForm) loginForm.addEventListener('submit', handleLogin);

  renderLessonCards();
  updateProgressUI();
});

window.cursoIngles = {
  startLesson,
  renderLessonCards,
  toggleTheme
};
