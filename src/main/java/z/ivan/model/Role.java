package z.ivan.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Role {

    private Long roleId;
    private int user;
    private int tutor;
    private int admin;

    public Role() {
    }

    public static List<String> getRolesNames() {
        return Arrays.asList("Admin", "Tutor", "User");
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getTutor() {
        return tutor;
    }

    public void setTutor(int tutor) {
        this.tutor = tutor;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return user == role.user &&
                tutor == role.tutor &&
                admin == role.admin &&
                Objects.equals(roleId, role.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, user, tutor, admin);
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", user=" + user +
                ", tutor=" + tutor +
                ", admin=" + admin +
                '}';
    }
}
