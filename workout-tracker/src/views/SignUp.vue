<script setup>
import SignUpForms from '../components/SignUpForms.vue';
import { uid } from 'uid';
import UserDataService  from "../services/userDataService";

const newUser = (name, email, password) => {
  UserDataService.create({
    id: uid(),
    name: name,
    email: email,
    password: password,
  })
  .then((response) => {
    console.log("Sucesso: ", response.data);
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