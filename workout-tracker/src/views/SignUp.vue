<script setup>
import SignUpForms from '../components/SignUpForms.vue';

import axios from 'axios';

const newUser = (name, email, password) => {
  axios.post('localhost:5137/signup', {
    name: name,
    email: email,
    password: password,
  })
  .then((response) => {
    console.log("Resposta do server: ", response.data);
  })
  .catch((error) => {
    console.log("Erro ao enviar cadastro: ", error);
  });
}

</script>

<template>
  <div class="flex justify-center align-center p-8">
    <SignUpForms
    @add-user="newUser" />
  </div>
</template>