<script>
    import { isAuthenticated, user } from "../store";;
</script>

<h1 class="mt-3">Account Details</h1>
<!--
{#if $isAuthenticated}
    <p><b> Name:</b> {user.name}</p>
    <p><b> Nichname:</b> {user.nickname}</p>
    <p><b> Email:</b> {user.email}</p>
{#if $user.user_roles && $user.user_roles.length > 0}
    <p><b>Roles:</b> {$user.user_roles}</p>
{/if}
{:else}
    <p> Not logged in</p>
{/if}
-->

