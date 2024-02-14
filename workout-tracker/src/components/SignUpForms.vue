<script setup>
import { reactive } from 'vue';
import { RouterLink } from 'vue-router';

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
    <div class="Container border-solid border-black bg-slate-400 border-2 rounded-md max-w-xl flex justify-center flex-col items-center p-10 gap-2">
        <h1 class="text-xl font-bold m-2">Bem Vindo!!!</h1>
        <h2>Faça login para acessar seus treinos salvos.</h2>
        <div>
            <p>Email: </p>
            <input type="text" name="Email" id="userEmail" class="rounded-md">
        </div>
        <div>
            <p>Senha: </p>
            <input type="text" name="Senha" id="userPassword" class="rounded-md">
        </div>
        <RouterLink class="underline active:bold" to="/signin">Cadastre-se</RouterLink>
        <button class="border-black rounded p-2 border-solid border-1 bg-slate-600 text-white active:bg-slate-400 active:font-bold">Confirmar</button>
    </div>
</template>