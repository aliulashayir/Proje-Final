import type { NextPage } from "next";
import { useCallback } from "react";
import InputField from "./input-field";
import { useRouter } from "next/router";
import Button from "./button";
import styles from "./group-component.module.css";

export type GroupComponentType = {
  className?: string;
};

const GroupComponent: NextPage<GroupComponentType> = ({ className = "" }) => {
  const router = useRouter();

  const onButtonContainerClick = useCallback(() => {
    router.push("/dashboard");
  }, [router]);

  const onRegisterContainerClick = useCallback(() => {
    router.push("/register");
  }, [router]);

  return (
    <div className={[styles.groupParent, className].join(" ")}>
      <div className={styles.emlakBuradaParent}>
        <div className={styles.emlakBurada}>Emlak Burada</div>
        <div className={styles.pleaseLoginYour}>Please Login your account.</div>
        <div className={styles.welcomeTo}>
          <span className={styles.welcome}>{`Welcome `}</span>t
          <span className={styles.welcome}>{`o `}</span>
        </div>
        <div className={styles.orContinueWith}>Or Continue With</div>
        <InputField email="Email" kamrulgmailcom="kamrul@gmail.com" />
        <InputField
          email="Password"
          kamrulgmailcom="*********"
          propTop="241px"
          propLeft="1px"
        />
        <div className={styles.button} onClick={onButtonContainerClick}>
          <Button logIn="Log In" />
        </div>
        <div className={styles.googleWrapper}>
          <div className={styles.google} onClick={onButtonContainerClick}>
            <div className={styles.googleChild} />
            <div className={styles.image198Parent}>
              <img
                className={styles.image198Icon}
                alt=""
                src="/image-198@2x.png"
              />
              <div className={styles.google1}>Google</div>
            </div>
          </div>
        </div>
        <div className={styles.rememberMeParent}>
          <div className={styles.rememberMe}>Remember me</div>
          <div className={styles.groupChild} />
        </div>
        <div className={styles.forgotPassword}>Forgot Password?</div>
      </div>
      <div className={styles.register} onClick={onRegisterContainerClick}>
        <div className={styles.newMemberHereContainer}>
          <span>New member here?</span>
          <span className={styles.registerNow}>{` Register Now `}</span>
        </div>
      </div>
    </div>
  );
};

export default GroupComponent;
