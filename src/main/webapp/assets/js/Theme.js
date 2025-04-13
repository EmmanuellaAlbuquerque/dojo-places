class Theme {
    constructor() {
        this.currentTheme = localStorage.getItem('theme') || 'light';
        document.documentElement.setAttribute('data-bs-theme', this.currentTheme);
        this.themeToggleBtn = document.getElementById('theme-toggle');
        this.addToggle();
        this.themeToggleBtn.innerHTML = this.currentTheme === 'light' ? "<i class=\"bi bi-moon-stars-fill\"></i> Tema Escuro" : "<i class=\"bi bi-sun-fill\"></i> Tema Claro";
    }

    addToggle() {
        if (this.themeToggleBtn) {
            this.themeToggleBtn.addEventListener('click', (event) => this.toggleTheme(event));
        }
    }

    toggleTheme(event) {
        this.currentTheme = localStorage.getItem('theme') || 'light';
        const newTheme = this.currentTheme === 'light' ? 'dark' : 'light';
        document.documentElement.setAttribute('data-bs-theme', newTheme);
        localStorage.setItem('theme', newTheme);
        location.reload();
    }
}