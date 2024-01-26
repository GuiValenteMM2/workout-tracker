<script setup>

defineEmits(['add-exercise']);

defineProps({
    name: {
        type: String,
        required: true,
    },
    sets: {
        type: String,
        required: true,
    },
    reps: {
        type: String,
        required: true,
    },
    weight: {
        type: String,
        required: true,
    }
});

</script>

<template>
    <tr class="">
        <td class="p-2">{{ name }}</td>
        <td class="p-2">{{ sets }}</td>
        <td class="p-2">{{ reps }}</td>
        <td class="p-2">{{ weight }}</td>
        <td>mexer</td>
        <td>excluir</td>
    </tr>
</template>