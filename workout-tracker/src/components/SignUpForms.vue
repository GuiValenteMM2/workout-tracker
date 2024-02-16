<script setup>
import { reactive } from 'vue';

const userData = reactive({
    name: "",
    email: "",
    password: "",
    invalid: null,
    errorMsg: "",
})

const emit = defineEmits(['add-user']);

const addUser = () => {
    userData.invalid = false;
    for (let key in userData) {
        if (userData.name != "" || userData.email != "" || userData.password != "") {
            emit('add-user', userData.name, userData.email, userData.password);
            userData.name = "";
            userData.email = "";
            userData.password = "";
            return;
        }
    }
    userData.invalid = true;
    userData.errorMsg = "Por favor preencha os campos!";
    
}
</script>

<template>
<div class="Container border-solid border-black bg-slate-400 border-2 rounded-md max-w-xl flex justify-center flex-col items-center p-10 gap-2">
        <h1 class="text-xl font-bold m-2">Cadastro</h1>
        <h2>Crie uma conta para registrar seus treinos!</h2>
        <div>
            <p>Nome: </p>
            <input type="text" name="name" id="userName" required class="rounded-md" v-model="userData.name">
            <p v-if="userData.invalid">{{ userData.errorMsg }}</p>
        </div>
        <div>
            <p>Email: </p>
            <input type="text" name="Email" id="userEmail" required class="rounded-md" v-model="userData.email">
            <p v-if="userData.invalid">{{ userData.errorMsg }}</p>
        </div>
        <div>
            <p>Senha: </p>
            <input type="text" name="Senha" id="userPassword" required class="rounded-md" v-model="userData.password">
            <p v-if="userData.invalid">{{ userData.errorMsg }}</p>
        </div>
        <button @click="addUser()" class="border-black rounded p-2 border-solid border-1 bg-slate-600 text-white active:bg-slate-400 active:font-bold">Cadastrar</button>
    </div>
</template>