import type { NextPage } from "next";
import { useCallback } from "react";
import InputField from "./input-field";
import Button from "./button";
import CreatePassword from "./create-password";
import FName from "./f-name";
import styles from "./register-form.module.css";

export type RegisterFormType = {
  className?: string;
};

const RegisterForm: NextPage<RegisterFormType> = ({ className = "" }) => {
  const onButtonContainerClick = useCallback(() => {
    // Please sync "onboarding 1" to the project
  }, []);

  return (
    <div className={[styles.registerForm, className].join(" ")}>
      <div className={styles.registerFormChild} />
      <div className={styles.emlakBurada}>Emlak Burada</div>
      <div className={styles.enterYourInformation}>
        Enter your information below to continue
      </div>
      <div className={styles.welcomeTo}>
        <span className={styles.welcome}>{`Welcome `}</span>t
        <span className={styles.welcome}>{`o `}</span>
      </div>
      <InputField
        email="Email"
        kamrulgmailcom="kamrul@gmail.com"
        propTop="249px"
        propLeft="115px"
      />
      <div className={styles.button} onClick={onButtonContainerClick}>
        <Button logIn="Create Account" propLeft="calc(50% - 260.5px)" />
      </div>
      <CreatePassword createPassword="Create Password" />
      <FName firstName="First name" kamrul="Kamrul" />
      <CreatePassword createPassword="Confirm Password" propLeft="386px" />
      <FName firstName="Last name" kamrul="Hasan" propLeft="386px" />
    </div>
  );
};

export default RegisterForm;
