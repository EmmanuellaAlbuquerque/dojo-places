class DeleteButton {
    constructor () {
        this.forms = document.getElementsByClassName("removeButton");
    }

    listeners () {
        for (let form of this.forms) {
            let placeName = form.getElementsByClassName("placeName")[0].value;
            form.onsubmit = (event) => this.confirmDelete(placeName);
        }
    }

    confirmDelete(placeName) {
        return confirm(`Você tem certeza que deseja deletar esse Local "${placeName}"?`);
    }
}