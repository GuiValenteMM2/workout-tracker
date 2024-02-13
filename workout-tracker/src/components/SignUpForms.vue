<script setup>
import { reactive } from 'vue';

const emit = defineEmits(['get-user']);

const user = reactive({
    name: "",
    password: "",
    invalid: null,
    errMsg: "",
})

const getUser = () => {
    user.invalid = false;
    if (user.name != "" || user.password != "") {
        emit("get-user", user.name, user.password);
        user.name = "";
        user.password = "";
        return;
    }
    user.invalid = true;
    user.errMsg = "Por favor preencha o formulário.";
}

</script>

<template>
    <div class="Container border-solid border-black bg-slate-400 justify-center align-center m- max-w-lg max-h-hscreen">
        <h1>Bem Vindo!!!</h1>
        <h2>Faça login para acessar seus treinos salvos.</h2>
        <div>
            <p>Email: </p>
            <input type="text" name="Email" id="userEmail">
        </div>
        <div>
            <p>Senha: </p>
            <input type="text" name="Senha" id="userPassword">
        </div>
        <button>Confirmar</button>
    </div>
</template>