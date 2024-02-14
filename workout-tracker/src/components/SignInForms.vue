<script setup>



</script>

<template>
<div class="Container border-solid border-black bg-slate-400 border-2 rounded-md max-w-xl flex justify-center flex-col items-center p-10 gap-2">
        <h1 class="text-xl font-bold m-2">Cadastro</h1>
        <h2>Crie uma conta para registrar seus treinos!</h2>
        <div>
            <p>Nome: </p>
            <input type="text" name="name" id="userName" class="rounded-md">
        </div>
        <div>
            <p>Email: </p>
            <input type="text" name="Email" id="userEmail" class="rounded-md">
        </div>
        <div>
            <p>Senha: </p>
            <input type="text" name="Senha" id="userPassword" class="rounded-md">
        </div>
        <button class="border-black rounded p-2 border-solid border-1 bg-slate-600 text-white active:bg-slate-400 active:font-bold">Cadastrar</button>
    </div>

</template>