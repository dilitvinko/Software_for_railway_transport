// import axios from 'axios';
//
// var options = {
//   url: 'http://localhost:8080/trains',
//   method: 'GET',
//   headers:
//     {
//       Authorization: 'Basic YWRtaW46YWRtaW4='
//     }
// }
// this.$http(options).then((response) => {
//   console.log(response.valueOf())
// });
var aut = 'Basic ' + btoa('admin:admin');
$.ajax({
  url: 'http://localhost:8080/test',
  headers: {
    "Authorization": aut
  },
success: function(data) {
  $('.results').html(data);
}
});
//
//
// var xhr = new XMLHttpRequest();
// xhr.open("GET", "http://localhost:8080/test", true);
// xhr.withCredentials = true;
// xhr.setRequestHeader("Authorization", 'Basic ' + btoa('admin:admin'));
// xhr.onload = function () {
//   console.log(xhr.responseText);
// };
// xhr.send();
//
// var session_url = 'http://localhost:8080/test';
// var uname = 'admin';
// var pass = 'admin';
// // axios.get(session_url, {}, {
// //   auth: {
// //     username: uname,
// //     password: pass
// //   }
// // }).then(function(response) {
// //   console.log('Authenticated');
// // }).catch(function(error) {
// //   console.log('Error on Authentication');
// // });
// //
// // axios.post(session_url, {}, {
// //   auth: {
// //     username: uname,
// //     password: pass
// //   }
// // }).then(function(response) {
// //   console.log('Authenticated');
// // }).catch(function(error) {
// //   console.log('Error on Authentication');
// // });
//
//
// // axios.post('http://localhost:8080/test',  {
// //    headers: { 'Authorization': + 'Basic YWRtaW46YWRtaW4=' }
// // }).then(function(response) {
// //   console.log('Authenticated');
// // }).catch(function(error) {
// //   console.log('Error on Authentication');
// // });
//
// var messageApi = Vue.resource('http://localhost:8080/cities',{
//   headers:
//     new Headers({
//       "Authorization": 'Basic ' + btoa('admin:admin'),
//     'Content-Type': 'application/json'
//   })
// });
// //messageApi.setRequestHeader("Authorization", 'Basic ' + btoa('admin:admin'));
// // //messageApi.http.headers().Authorization = 'Basic YWRtaW46YWRtaW4=';
// //
// //
// //
// Vue.component('message-row', {
//   props: ['message'],
//   template: '<div><i>({{ message.id }})</i>{{ message.name }} </div>'
// });
//
// Vue.component('messages-list', {
//   props: ['messages'],
//   template: '<div><message-row v-for="message in messages" :key="message.id" :message="message" /></div>',
//   created: function(){
//     messageApi.get().then(result =>
//       result.json().then(data =>
//         data.forEach(message => this.messages.push(message))
//       )
//     )
//   }
// });
//
//
// var app = new Vue({
//   el: '#app',
//   template: '<messages-list :messages="messages"/>',
//   data: {
//     messages: [
//     ]
//   }
// });
//
// // var url = 'https://exemple.com';
// // fetch(url, {
// //   method: 'POST',
// //   headers: new Headers({
// //     'Authorization': 'Bearer ' + token,
// //     'Content-Type': 'application/json'
// //   }),
// //   body: { /* some data */ }
// // });
//
//
