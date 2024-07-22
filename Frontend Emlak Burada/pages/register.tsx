import type { NextPage } from "next";
import RegisterForm from "../components/register-form";
import styles from "./register.module.css";

const Register: NextPage = () => {
  return (
    <div className={styles.register}>
      <RegisterForm />
    </div>
  );
};

export default Register;
