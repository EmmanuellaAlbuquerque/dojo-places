class ViaCepApi {

    constructor() {
        const API_URL = 'https://viacep.com.br/ws/';

        console.log("Via Cep Api");

        document.querySelector("#cep").addEventListener("input", () => {
            let request_url = API_URL + `${event.target.value}` + '/json/';
            console.log(request_url);

            this.fetchData(request_url);
        });
    }

    async fetchData(request_url) {
        let neighborhoodInput = document.getElementById("neighborhood");
        let cityInput = document.getElementById("city");

        try {
            const response = await fetch(request_url);
            const data = await response.json();

            neighborhoodInput.value = data.bairro;
            neighborhoodInput.setAttribute("readonly", true);

            cityInput.value = data.localidade;
            cityInput.setAttribute("readonly", true);
        } catch (error) {
            neighborhoodInput.setAttribute("readonly", false);
            cityInput.setAttribute("readonly", false);
        }
    }
}
