var messageApi = Vue.resource('http://localhost:8080/cities',{
  headers: new Headers({
    'Authorization': 'Basic YWRtaW46YWRtaW4=',
    'Content-Type': 'application/json'
  })
});

Vue.component('message-row', {
  props: ['message'],
  template: '<div><i>({{ message.id }})</i>{{ message.name }} </div>'
});

Vue.component('messages-list', {
  props: ['messages'],
  template: '<div><message-row v-for="message in messages" :key="message.id" :message="message" /></div>',
  created: function(){
    messageApi.get().then(result =>
      result.json().then(data =>
        data.forEach(message => this.messages.push(message))
      )
    )
  }
});


var app = new Vue({
  el: '#app',
  template: '<messages-list :messages="messages"/>',
  data: {
    messages: [
    ]
  }
});

// var url = 'https://exemple.com';
// fetch(url, {
//   method: 'POST',
//   headers: new Headers({
//     'Authorization': 'Bearer ' + token,
//     'Content-Type': 'application/json'
//   }),
//   body: { /* some data */ }
// });


