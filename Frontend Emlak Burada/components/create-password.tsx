import type { NextPage } from "next";
import { useMemo, type CSSProperties } from "react";
import styles from "./create-password.module.css";

export type CreatePasswordType = {
  className?: string;
  createPassword?: string;

  /** Style props */
  propLeft?: CSSProperties["left"];
};

const CreatePassword: NextPage<CreatePasswordType> = ({
  className = "",
  createPassword,
  propLeft,
}) => {
  const createPasswordStyle: CSSProperties = useMemo(() => {
    return {
      left: propLeft,
    };
  }, [propLeft]);

  return (
    <div
      className={[styles.createPassword, className].join(" ")}
      style={createPasswordStyle}
    >
      <div className={styles.createPassword1}>{createPassword}</div>
      <div className={styles.createPasswordChild} />
      <div className={styles.div}>*********</div>
      <img className={styles.iconRight} alt="" src="/iconright.svg" />
    </div>
  );
};

export default CreatePassword;
