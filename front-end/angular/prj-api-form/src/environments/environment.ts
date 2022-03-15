// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  urlApiViaCep: 'https://viacep.com.br/ws',
  urlApiIbge: 'https://servicodados.ibge.gov.br/api/v1/localidades',
  loginUser: 'maria',
  passwordUser: '8311',
  firebaseConfig:
  {
    apiKey: "AIzaSyCxTTZdA5_JOzTYe6bcAdyyTKSghwEEikM",
    authDomain: "prj-api-form.firebaseapp.com",
    projectId: "prj-api-form",
    storageBucket: "prj-api-form.appspot.com",
    messagingSenderId: "608254139675",
    appId: "1:608254139675:web:cbe69d040e297e472b87be"
  }
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
