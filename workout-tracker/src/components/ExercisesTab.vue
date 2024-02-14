<script setup>

defineEmits(['add-exercise', 'delete-exercise', 'edit-exercise']);

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
        <td><button @click="$emit('delete-exercise')">
                <svg xmlns="http://www.w3.org/2000/svg" width="1.5em" height="1.5em" viewBox="0 0 24 24" class="active:text-white">
		          <path fill="currentColor" d="M9 3v1H4v2h1v13a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V6h1V4h-5V3zM7 6h10v13H7zm2 2v9h2V8zm4 0v9h2V8z" />
	            </svg>
            </button></td>
    </tr>
</template>