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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ui.VerContrato;

/**
 *
 * @author ferna
 */
public class MetodosDocumentos {

    public static void GrabarNuevaFactura(Factura nuevaFactura) {
        try {
            PreparedStatement ps2 = Conexiones.Conexion.getConexion().prepareStatement("insert into factura values (?,?,?,?,?,?,?,?,?,?,?)");
            java.util.Date fecha = new Date();
            java.sql.Date fecharegistro = new java.sql.Date(fecha.getTime());
            nuevaFactura.setCodigoFactura(CodigoUltimaFactura() + 1);
            ps2.setInt(1, nuevaFactura.getCodigoFactura());
            ps2.setDate(2, fecharegistro);
            ps2.setInt(3, nuevaFactura.getCodigoCliente());
            ps2.setString(4, nuevaFactura.getNombre());
            ps2.setString(5, nuevaFactura.getDireccion());
            ps2.setString(6, nuevaFactura.getNit());
            ps2.setInt(7, nuevaFactura.getCodigoProducto());
            ps2.setString(8, nuevaFactura.getNombreProducto());
            ps2.setDouble(9, nuevaFactura.getPrecioProducto());
            ps2.setInt(10, nuevaFactura.getCuotas());
            ps2.setDouble(11, nuevaFactura.getMontoCuota());
            ps2.executeUpdate();
            GrabarContrato(nuevaFactura);
            MetodosProducto.salidaStock(nuevaFactura.getCodigoProducto());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static ArrayList<Vector> MostrarTodasFacturas(int idCliente) {
        ArrayList<Vector> listadoFacturas = new ArrayList();
        ResultSet res;
        res = Conexiones.Conexion.Consulta("select cfactura, ccliente, nombre from factura where ccliente='" + idCliente + "'");
        try {
            while (res.next()) {
                Vector v = new Vector();
                v.add(res.getInt(1));
                v.add(res.getInt(2));
                v.add(res.getString(3));
                listadoFacturas.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
                    "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
        return listadoFacturas;
    }

    public static Vector MostrarDetalleFactura(int idFactura) {
        Vector v = new Vector();
        ResultSet res = Conexiones.Conexion.Consulta("select fecha, ccliente, nombre, direccion, nitcliente,"
                + "cproducto,nproducto,pproducto,cuotas from factura where cfactura='"
                + idFactura + "'");
        try {
            while (res.next()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fecha = sdf.format(res.getDate(1));
                v.add(fecha);
                v.add(res.getInt(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getString(5));
                v.add(res.getInt(6));
                v.add(res.getString(7));
                v.add(res.getDouble(8));
                v.add(res.getInt(9));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
                    "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }

        return v;
    }

    public static Vector mostrarDetalleContrato(int idContrato) {
        Vector v = new Vector();
        ResultSet res;
        res = Conexiones.Conexion.Consulta("select ccontrato, ccliente, cfactura, fechainicial, cuotas, "
                + "mcuota from contrato where cfactura='" + idContrato + "'");
        try {
            while (res.next()) {
                v.add(res.getInt(1));
                v.add(res.getInt(2));
                v.add(res.getInt(3));
                v.add(res.getDate(4));
                v.add(res.getInt(5));
                v.add(res.getDouble(6));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL INGRESAR DATOS, VERIFIQUE");
        } catch (SQLException ex) {
            Logger.getLogger(VerContrato.class.getName()).log(Level.SEVERE, null, ex);
        }

        return v;
    }

    public static void GrabarFechas(Factura nuevaFactura) {
        try {
            Calendar fecha = Calendar.getInstance();
            int ccontrato = MetodosDocumentos.CodigoUltimoContrato();
            if (nuevaFactura.getCuotas() == 3) {
                PreparedStatement ps2 = Conexiones.Conexion.getConexion().prepareStatement(
                        "insert into fechaspago values (?, ?,?,?,null,null,null,null,null,null,null,null,null)");

                ps2.setInt(1, ccontrato);
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(2, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(3, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(4, new java.sql.Date(fecha.getTimeInMillis()));
                ps2.executeUpdate();
            }
            if (nuevaFactura.getCuotas() == 6) {
                PreparedStatement ps2 = Conexiones.Conexion.getConexion().prepareStatement(
                        "insert into fechaspago values (?, ?,?,?,?,?,?,null,null,null,null,null,null)",
                        PreparedStatement.RETURN_GENERATED_KEYS);

                ps2.setInt(1, ccontrato);
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(2, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(3, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(4, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(5, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(6, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(7, new java.sql.Date(fecha.getTimeInMillis()));

                ps2.executeUpdate();
            }
            if (nuevaFactura.getCuotas() == 10) {
                PreparedStatement ps2 = Conexiones.Conexion.getConexion().prepareStatement(
                        "insert into fechaspago values (?, ?,?,?,?,?,?,?,?,?,?,null,null)",
                        PreparedStatement.RETURN_GENERATED_KEYS);

                ps2.setInt(1, ccontrato);
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(2, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(3, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(4, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(5, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(6, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(7, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(8, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(9, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(10, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(11, new java.sql.Date(fecha.getTimeInMillis()));

                ps2.executeUpdate();
            }
            if (nuevaFactura.getCuotas() == 12) {
                PreparedStatement ps2 = Conexiones.Conexion.getConexion().prepareStatement(
                        "insert into fechaspago values (?, ?,?,?,?,?,?,?,?,?,?,?,?)",
                        PreparedStatement.RETURN_GENERATED_KEYS);

                ps2.setInt(1, ccontrato);
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(2, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(3, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(4, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(5, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(6, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(7, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(8, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(9, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(10, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(11, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(12, new java.sql.Date(fecha.getTimeInMillis()));
                fecha.add(Calendar.MONTH, 1);
                ps2.setDate(13, new java.sql.Date(fecha.getTimeInMillis()));

                ps2.executeUpdate();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "La BD tiene problemas: " + e.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void GrabarContrato(Factura nuevaFactura) {
        try {
            int pagadas = 0;
            PreparedStatement ps2 = Conexiones.Conexion.getConexion().prepareStatement("insert into contrato values (?,?,?,?,?,?,?,?,?)");

            java.util.Date fecha = new Date();
            java.sql.Date fecharegistro = new java.sql.Date(fecha.getTime());

            int nuevoContrato = CodigoUltimoContrato() + 1;
            ps2.setInt(1, nuevoContrato);
            ps2.setInt(2, nuevaFactura.getCodigoCliente());
            ps2.setInt(3, nuevaFactura.getCodigoFactura());
            ps2.setDate(4, fecharegistro);
            ps2.setInt(5, nuevaFactura.getCuotas());
            ps2.setInt(6, pagadas);
            ps2.setInt(7, nuevaFactura.getCuotas());
            ps2.setDouble(8, nuevaFactura.getMontoCuota());
            ps2.setDouble(9, nuevaFactura.getPrecioProducto());
            ps2.executeUpdate();
            GrabarFechas(nuevaFactura);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "La BD tiene problemas: " + e.getMessage(),
                    "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static int CodigoUltimaFactura() {
        int cnuevo = 0;
        ResultSet rs;
        try {
            Statement mcodigo = Conexiones.Conexion.getConexion().createStatement();
            rs = mcodigo.executeQuery("select cfactura from factura");
            while (rs.next()) {
                String ccliente = rs.getString("CFACTURA");
                if (Integer.parseInt(ccliente) > cnuevo) {
                    cnuevo = Integer.parseInt(ccliente);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());

        }
        return cnuevo;
    }

    public static int CodigoUltimoContrato() {
        int cnuevo = 0;
        ResultSet rs;
        try {
            Statement mcodigo = Conexiones.Conexion.getConexion().createStatement();
            rs = mcodigo.executeQuery("select ccontrato from contrato");
            while (rs.next()) {
                String ccliente = rs.getString("CCONTRATO");
                if (Integer.parseInt(ccliente) > cnuevo) {
                    cnuevo = Integer.parseInt(ccliente);
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());

        }
        return cnuevo;
    }

    public static boolean ExisteFactura(int id) {
        int aux;
        boolean r = false;
        ResultSet rs;
        try {
            Statement mcodigo = Conexiones.Conexion.getConexion().createStatement();
            rs = mcodigo.executeQuery("select cfactura from factura");
            while (rs.next()) {
                String cfactura = rs.getString("CFACTURA");
                aux = Integer.parseInt(cfactura);
                if (id == aux) {
                    r = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());

        }
        return r;
    }
}
