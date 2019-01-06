export class User {
  lastName: any;
  lastNname: any;
    constructor(
        public name: string,
        public lastname: string,
        public username: string,
        public email: string,
        public password: string,
        public city: string,
    ) {}
}