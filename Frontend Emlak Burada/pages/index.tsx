import type { NextPage } from "next";
import GroupComponent from "../components/group-component";
import styles from "./index.module.css";

const LoginPage: NextPage = () => {
  return (
    <div className={styles.loginPage}>
      <div className={styles.loginForm}>
        <div className={styles.loginFormChild} />
        <GroupComponent />
      </div>
      <img className={styles.iconRight} alt="" src="/iconright.svg" />
    </div>
  );
};

export default LoginPage;
