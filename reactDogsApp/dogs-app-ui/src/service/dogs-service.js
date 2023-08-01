import http from './axios-requests'

export function getAllDogs() {
    return http.get("/dogs");
}
