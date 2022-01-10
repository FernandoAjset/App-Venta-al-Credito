/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class MetodosCliente {

    public static void GrabarNuevoCliente(String nombre, String apellido, String direccion, String nit, int cel) {
        try {
            PreparedStatement ps2 = Conexiones.Conexion.getConexion().prepareStatement("insert into clientes values (null,?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            ps2.setString(1, nombre);
            ps2.setString(2, apellido);
            ps2.setString(3, direccion);
            ps2.setString(4, nit);
            ps2.setInt(5, cel);
            ps2.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());

        }
    }

    public static int CodigoUltimo() {
        int cnuevo = 0;
        ResultSet rs;
        try {
            Statement mcodigo = Conexiones.Conexion.getConexion().createStatement();
            rs = mcodigo.executeQuery("select ccliente from clientes");
            while (rs.next()) {
                String ccliente = rs.getString("CCLIENTE");
                if (Integer.parseInt(ccliente) > cnuevo) {
                    cnuevo = Integer.parseInt(ccliente);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());

        }
        return cnuevo;
    }

    public static boolean ExisteCodigoCliente(int id) {
        int aux;
        boolean r = false;
        ResultSet rs;
        try {
            Statement mcodigo = Conexiones.Conexion.getConexion().createStatement();
            rs = mcodigo.executeQuery("select ccliente from clientes");
            while (rs.next()) {
                String ccliente = rs.getString("CCLIENTE");
                aux = Integer.parseInt(ccliente);
                if (id == aux) {
                    r = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());

        }
        return r;
    }

    public static ArrayList<Vector> MostrarClientes() {
        Statement ps = null;
        ResultSet rs;
        ArrayList<Vector> listadoClientes = new ArrayList();
        try {
            ps = Conexiones.Conexion.getConexion().createStatement();
            rs = ps.executeQuery("select ccliente,ncliente,acliente,dcliente,nitcliente,tcliente from clientes");
            while (rs.next()) {
                Vector cliente = new Vector();
                cliente.add(rs.getString("CCLIENTE"));
                cliente.add(rs.getString("NCLIENTE"));
                cliente.add(rs.getString("ACLIENTE"));
                cliente.add(rs.getString("DCLIENTE"));
                cliente.add(rs.getString("NITCLIENTE"));
                cliente.add(rs.getString("TCLIENTE"));
                listadoClientes.add(cliente);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return listadoClientes;
    }

    public static Cliente DetallesCliente(int id) {
        Cliente detalleCliente = new Cliente();

        Statement ps = null;
        ResultSet rs;

        try {
            ps = Conexiones.Conexion.getConexion().createStatement();

            rs = ps.executeQuery("select ccliente, ncliente,acliente,dcliente,nitcliente, tcliente from clientes where ccliente='" + id + "'");
            while (rs.next()) {
                detalleCliente.setCodigoCliente(rs.getInt("CCLIENTE"));
                detalleCliente.setNombre(rs.getString("NCLIENTE"));
                detalleCliente.setApellido(rs.getString("ACLIENTE"));
                detalleCliente.setDireccion(rs.getString("DCLIENTE"));
                detalleCliente.setNit(rs.getString("NITCLIENTE"));
                detalleCliente.setTelefono(rs.getLong("TCLIENTE"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MetodosCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return detalleCliente;
    }
}
